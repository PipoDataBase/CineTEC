using Microsoft.AspNetCore.Mvc;
using REST_API.Data;
using System.Text.Json.Serialization;
using System.Text.Json;
using REST_API.Models;
using Microsoft.EntityFrameworkCore;

namespace REST_API.Controllers
{
    [ApiController]
    [Route("api/projections")]
    public class ProjectionsController : Controller
    {
        private readonly CineTECDbContext _dbContext;
        public ProjectionsController(CineTECDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpGet]
        [Route("{room_Id:Guid}")]
        public async Task<IActionResult> GetAllProjections([FromRoute] Guid room_Id)
        {
            var projections = await _dbContext.Projections.Where(x => x.Room_Id == room_Id).ToListAsync();
            if (projections == null || projections.Count == 0)
            {
                return NotFound();
            }

            return Ok(projections);
        }

        [HttpPost]
        public async Task<IActionResult> AddProjection([FromBody] Projection projectionRequest)
        {
            projectionRequest.Id = Guid.NewGuid();
            await _dbContext.Projections.AddAsync(projectionRequest);
            await _dbContext.SaveChangesAsync();

            var room = await _dbContext.Rooms.FindAsync(projectionRequest.Room_Id);
            if (room != null)
            {
                room.Projections.Add(projectionRequest);
            }

            await _dbContext.SaveChangesAsync();

            return Ok(JsonSerializer.Serialize(projectionRequest, jsonSerializerOptions));
        }

        [HttpGet]
        [Route("{room_Id:Guid}/{id:Guid}")]
        public async Task<IActionResult> GetProjection([FromRoute] Guid room_Id, Guid id)
        {
            var projection = await _dbContext.Projections.FirstOrDefaultAsync(x => x.Id == id);
            if (projection == null)
            {
                return NotFound();
            }

            return Ok(projection);
        }

        [HttpPut]
        [Route("{room_Id:Guid}/{id:Guid}")]
        public async Task<IActionResult> UpdateProjection([FromRoute] Guid room_Id, Guid id, Projection updateProjectionRequest)
        {
            var projection = await _dbContext.Projections.FindAsync(id);
            if (projection == null)
            {
                return NotFound();
            }

            projection.Movie_Id = updateProjectionRequest.Movie_Id;
            projection.DateTime = updateProjectionRequest.DateTime;
            projection.ProjectionType = updateProjectionRequest.ProjectionType;
            projection.Language = updateProjectionRequest.Language;
            await _dbContext.SaveChangesAsync();

            return Ok(projection);
        }

        [HttpDelete]
        [Route("{id:Guid}")]
        public async Task<IActionResult> DeleteProjection([FromRoute] Guid id)
        {
            var projection = await _dbContext.Projections.FindAsync(id);
            if (projection == null)
            {
                return NotFound();
            }

            _dbContext.Projections.Remove(projection);
            await _dbContext.SaveChangesAsync();

            return Ok(projection);
        }

        private static readonly JsonSerializerOptions jsonSerializerOptions = new JsonSerializerOptions { ReferenceHandler = ReferenceHandler.Preserve };
    }
}
