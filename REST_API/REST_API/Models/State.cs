using System.ComponentModel.DataAnnotations;

namespace REST_API.Models
{
    public class State
    {
        [Key]
        [Required]
        public int Id { get; set; }

        public string Name { get; set; } // cannot have the same name (State)
    }
}
