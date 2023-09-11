using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using REST_API.Data;
using REST_API.Models;

namespace REST_API.Controllers
{
    [ApiController]
    [Route("api/branch-offices")]
    public class BranchOfficesController : Controller
    {
        private readonly CineTECDbContext _dbContext;
        public BranchOfficesController(CineTECDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllBranches()
        {
            try
            {
                var branches = await _dbContext.BranchOffices
                    .Select(b => new
                    {
                        b.Id,
                        b.Location,
                        b.Name,
                        b.Restriction,
                        N_Rooms = _dbContext.Rooms.Count(r => r.Branch_Id == b.Id)
                    })
                    .ToListAsync();

                return Ok(branches);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal Server Error: {ex}");
            }
        }

        [HttpPost]
        public async Task<IActionResult> AddBranch([FromBody] BranchOffice branchRequest)
        {
            branchRequest.Id = Guid.NewGuid();
            await _dbContext.BranchOffices.AddAsync(branchRequest);
            await _dbContext.SaveChangesAsync();

            return Ok(branchRequest);
        }

        [HttpGet]
        [Route("{id:Guid}")]
        public async Task<IActionResult> GetBranch([FromRoute] Guid id)
        {
            var branch = await _dbContext.BranchOffices.FirstOrDefaultAsync(x => x.Id == id);
            if (branch == null)
            {
                return NotFound();
            }

            int nRooms = await _dbContext.Rooms.CountAsync(r => r.Branch_Id == id);
            var branchWithRoomsCount = new
            {
                Id = branch.Id,
                Location = branch.Location,
                Name = branch.Name,
                Restriction = branch.Restriction,
                N_Rooms = nRooms
            };

            return Ok(branchWithRoomsCount);
        }

        [HttpPut]
        [Route("{id:Guid}")]
        public async Task<IActionResult> UpdateBranch([FromRoute] Guid id, BranchOffice updateBranchRequest)
        {
            var branch = await _dbContext.BranchOffices.FindAsync(id);
            if (branch == null)
            {
                return NotFound();
            }

            branch.Location = updateBranchRequest.Location;
            branch.Name = updateBranchRequest.Name;
            branch.Restriction = updateBranchRequest.Restriction;
            await _dbContext.SaveChangesAsync();

            return Ok(branch);
        }

        [HttpDelete]
        [Route("{id:Guid}")]
        public async Task<IActionResult> DeleteBranch([FromRoute] Guid id)
        {
            var branch = await _dbContext.BranchOffices.FindAsync(id);
            if (branch == null)
            {
                return NotFound();
            }

            _dbContext.BranchOffices.Remove(branch);
            await _dbContext.SaveChangesAsync();

            return Ok(branch);
        }
    }
}
