using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace REST_API.Models
{
    public class Projection
    {
        [Key]
        [Required]
        public Guid Id { get; set; }

        [Required]
        [ForeignKey("Room")]
        public Guid Room_Id { get; set; }

        [Required]
        [ForeignKey("Movie")]
        public Guid Movie_Id { get; set; }

        public string DateTime { get; set; }

        public string ProjectionType { get; set; }

        public string Language { get; set; }

        public virtual Room Room { get; set; }

        public virtual Movie Movie { get; set; }
    }
}
