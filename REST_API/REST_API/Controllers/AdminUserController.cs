using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using REST_API.Data;
using REST_API.Models;

namespace REST_API.Controllers
{
    [ApiController]
    [Route("api/admin-users")]
    public class AdminUserController : Controller
    {
        private readonly CineTECDbContext _dbContext;
        public AdminUserController(CineTECDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllAdminUsers()
        {
            var admins = await _dbContext.Admins.ToListAsync();
            return Ok(admins);
        }

        [HttpPost]
        public async Task<IActionResult> AddAdmin([FromBody] AdminUser adminRequest)
        {
            await _dbContext.Admins.AddAsync(adminRequest);
            await _dbContext.SaveChangesAsync();
            return Ok(adminRequest);
        }
    }
}
