using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using REST_API.Data;
using REST_API.Models;

namespace REST_API.Controllers
{
    [ApiController]
    [Route("api/movies")]
    public class MoviesController : Controller
    {
        private readonly CineTECDbContext _dbContext;
        public MoviesController(CineTECDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllMovies()
        {
            var movies = await _dbContext.Movies.ToListAsync();
            return Ok(movies);
        }

        [HttpPost]
        public async Task<IActionResult> AddMovie([FromBody] Movie movieRequest)
        {
            movieRequest.Id = Guid.NewGuid();
            await _dbContext.Movies.AddAsync(movieRequest);
            await _dbContext.SaveChangesAsync();

            return Ok(movieRequest);
        }

        [HttpGet]
        [Route("{id:Guid}")]
        public async Task<IActionResult> GetMovie([FromRoute] Guid id)
        {
            var movie = await _dbContext.Movies.FirstOrDefaultAsync(x => x.Id == id);
            if (movie == null)
            {
                return NotFound();
            }

            return Ok(movie);
        }

        [HttpPut]
        [Route("{id:Guid}")]
        public async Task<IActionResult> UpdateMovie([FromRoute] Guid id, Movie updateMovieRequest)
        {
            var movie = await _dbContext.Movies.FindAsync(id);
            if (movie == null)
            {
                return NotFound();
            }

            movie.OriginalName = updateMovieRequest.OriginalName;
            movie.Director = updateMovieRequest.Director;
            movie.CommercialName = updateMovieRequest.CommercialName;
            movie.Classification = updateMovieRequest.Classification;
            movie.ImagePath = updateMovieRequest.ImagePath;
            movie.Protagonists = updateMovieRequest.Protagonists;
            movie.Duration = updateMovieRequest.Duration;
            await _dbContext.SaveChangesAsync();

            return Ok(movie);
        }

        [HttpDelete]
        [Route("{id:Guid}")]
        public async Task<IActionResult> DeleteMovie([FromRoute] Guid id)
        {
            var movie = await _dbContext.Movies.FindAsync(id);
            if (movie == null)
            {
                return NotFound();
            }

            _dbContext.Movies.Remove(movie);
            await _dbContext.SaveChangesAsync();

            return Ok(movie);
        }
    }
}
