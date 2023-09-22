using Microsoft.AspNetCore.Mvc;
using REST_API.Data;
using REST_API.Models;
using System.Text.Json.Serialization;
using System.Text.Json;
using Microsoft.EntityFrameworkCore;

namespace REST_API.Controllers
{
    [ApiController]
    [Route("api/rooms")]
    public class RoomsController : Controller
    {
        private readonly CineTECDbContext _dbContext;
        public RoomsController(CineTECDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpGet]
        [Route("{branch_Id:Guid}")]
        public async Task<IActionResult> GetAllRooms([FromRoute] Guid branch_Id)
        {
            try
            {
                var rooms = await _dbContext.Rooms
                    .Where(r => r.Branch_Id == branch_Id)
                    .Select(r => new
                    {
                        r.Id,
                        r.Branch_Id,
                        r.N_Rows,
                        r.N_Columns,
                        N_Projections = r.Projections.Count()
                    })
                    .ToListAsync();

                return Ok(rooms);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal Server Error: {ex}");
            }
        }

        [HttpPost]
        public async Task<IActionResult> AddRoom([FromBody] Room roomRequest)
        {
            roomRequest.Id = Guid.NewGuid();
            await _dbContext.Rooms.AddAsync(roomRequest);
            await _dbContext.SaveChangesAsync();

            var branch = await _dbContext.BranchOffices.FindAsync(roomRequest.Branch_Id);
            if (branch != null)
            {
                branch.Rooms.Add(roomRequest);
            }

            await _dbContext.SaveChangesAsync();

            return Ok(JsonSerializer.Serialize(roomRequest, jsonSerializerOptions));
        }


        [HttpGet]
        [Route("{branch_Id:Guid}/{id:Guid}")]
        public async Task<IActionResult> GetRoom([FromRoute] Guid branch_Id, Guid id)
        {
            var room = await _dbContext.Rooms.FirstOrDefaultAsync(x => x.Id == id);
            if (room == null)
            {
                return NotFound();
            }

            int nProjections = await _dbContext.Projections.CountAsync(r => r.Room_Id == id);
            var roomWithProjectionsCount = new
            {
                Id = room.Id,
                Branch_Id = room.Branch_Id,
                N_Rows = room.N_Rows,
                N_Columns = room.N_Columns,
                N_Projections = nProjections
            };

            return Ok(roomWithProjectionsCount);
        }

        [HttpPut]
        [Route("{branch_Id:Guid}/{id:Guid}")]
        public async Task<IActionResult> UpdateBranch([FromRoute] Guid branch_Id, Guid id, Room updateRoomRequest)
        {
            var room = await _dbContext.Rooms.FindAsync(id);
            if (room == null)
            {
                return NotFound();
            }

            room.N_Rows = updateRoomRequest.N_Rows;
            room.N_Columns = updateRoomRequest.N_Columns;
            await _dbContext.SaveChangesAsync();

            return Ok(room);
        }

        [HttpDelete]
        [Route("{id:Guid}")]
        public async Task<IActionResult> DeleteRoom([FromRoute] Guid id)
        {
            var room = await _dbContext.Rooms.FindAsync(id);
            if (room == null)
            {
                return NotFound();
            }

            _dbContext.Rooms.Remove(room);
            await _dbContext.SaveChangesAsync();

            return Ok(room);
        }

        private static readonly JsonSerializerOptions jsonSerializerOptions = new JsonSerializerOptions { ReferenceHandler = ReferenceHandler.Preserve };
    }
}
