using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace REST_API.Models
{
    public class Seat_Room
    {
        //[ForeignKey("State")]
        [Key]
        [Required]
        public Guid Room_Id { get; set; }


        public virtual ICollection<Seat> Seats { get; set; } = new List<Seat>();

    }
}