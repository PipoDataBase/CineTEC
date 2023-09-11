using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace REST_API.Models
{
    public class Room
    {
        [Key]
        [Required]
        public Guid Id { get; set; }

        [Required]
        [ForeignKey("BranchOffice")]
        public Guid Branch_Id { get; set; }

        public int N_Rows { get; set; }

        public int N_Columns { get; set; }

        public virtual BranchOffice BranchOffice { get; set; }

        // Relationship between a room and its projections
        public virtual ICollection<Projection> Projections { get; set; } = new List<Projection>();

        // The N_Projections property will be calculated
        public long N_Projections => Projections?.Count ?? 0;
    }
}
