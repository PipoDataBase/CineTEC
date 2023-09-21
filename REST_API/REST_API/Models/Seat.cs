using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Reflection.Metadata;

namespace REST_API.Models
{
    public class Seat
    {
        [Key]
        [Required]
        public Guid Id { get; set; } // Guid 0001asdas

        [Required]
        public string Public_Id{ get; set; } // String A1, A2

        [Required]
        [ForeignKey("State")]
        public int State_Id { get; set; }

        // [Required]
        // [ForeignKey("State")]
        // N_Bill

    }
}
