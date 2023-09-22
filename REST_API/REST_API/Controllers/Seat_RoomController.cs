using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
//using Microsoft.CodeAnalysis.Operations;
using Microsoft.EntityFrameworkCore;
using REST_API.Data;
using REST_API.Models;

namespace REST_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class Seat_RoomController : Controller
    {
        private readonly CineTECDbContext _context;

        public Seat_RoomController(CineTECDbContext context)
        {
            _context = context;
        }

        // GET: api/Seat_Room
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Seat_Room>>> GetSeat_Rooms()
        {
            return await _context.Seat_Rooms.ToListAsync();
        }

        // GET: api/Seat_Room/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Seat_Room>> GetSeat_Room(Guid id)
        {
            var seat_Room = await _context.Seat_Rooms.FindAsync(id);

            if (seat_Room == null)
            {
                return NotFound();
            }
            try
            {
                var seat_Rooms = await _context.Seat_Rooms
                    .Where(s => s.Room_Id== id)
                    .Select(s => new
                    {
                        s.Room_Id,
                        s.Seats,
                        N_Seats = s.Seats.Count()
                    })
                    .ToListAsync();

                return Ok(seat_Rooms);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal Server Error: {ex}");
            }

            //Console.WriteLine(seat_Room.Seats.Count());
            //return seat_Room;
        }

        // PUT: api/Seat_Room/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutSeat_Room(Guid id, Seat_Room seat_Room)
        {
            if (id != seat_Room.Room_Id)
            {
                return BadRequest();
            }

            _context.Entry(seat_Room).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!Seat_RoomExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Seat_Room   *Me genera con un solo cuarto, no me sirve la generacion automatica
        // If you give a Seat, it will create the Seat_Room with the Seat.
        // iF you don't give a Seat [], then a Seat_Room will be created with a list of Rooms acording to the N_Rows and N_Colums of the Room given ID
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Seat_Room>> PostSeat_Room(Seat_Room seat_Room)
        {

            if (seat_Room.Seats.Count > 0){

                _context.Seat_Rooms.Add(seat_Room);
                await _context.SaveChangesAsync();

            }
            else {
                var room = await _context.Rooms.FindAsync(seat_Room.Room_Id);  // Probar el otro FIND
                if (room == null)
                {
                    return NotFound();
                }
                else
                {
                    string rowHeaders = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    for (int i = 0; i < room.N_Rows; i++)
                    {
                        for (int j = 1; j <= room.N_Columns; j++)
                        {
                            Seat seatRequest = new Seat();
                            seatRequest.Id = Guid.NewGuid();
                            seatRequest.Public_Id = rowHeaders[i] + j.ToString();
                            seatRequest.State_Id = 1;
                            seat_Room.Seats.Add(seatRequest);
                        }
                    }
                }
                _context.Seat_Rooms.Add(seat_Room);
                await _context.SaveChangesAsync();
            }
            return Ok(seat_Room);
        }

        // DELETE: api/Seat_Room/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteSeat_Room(Guid id)
        {
            var seat_Room = await _context.Seat_Rooms.FindAsync(id);
            if (seat_Room == null)
            {
                return NotFound();
            }
            _context.Seat_Rooms.Remove(seat_Room);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool Seat_RoomExists(Guid id)
        {
            return _context.Seat_Rooms.Any(e => e.Room_Id == id);
        }
    }
}
