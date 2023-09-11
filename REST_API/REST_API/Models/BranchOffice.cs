using System.ComponentModel.DataAnnotations;

namespace REST_API.Models
{
    public class BranchOffice
    {
        [Key]
        [Required]
        public Guid Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public string Location { get; set; }

        public string Restriction { get; set; }

        // Relationship between a branch and its rooms
        public virtual ICollection<Room> Rooms { get; set; } = new List<Room>();

        // The N_Rooms property will be calculated
        public long N_Rooms => Rooms?.Count ?? 0;
    }
}
