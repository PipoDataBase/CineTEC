using System.ComponentModel.DataAnnotations;

namespace REST_API.Models
{
    public class Movie
    {
        [Key]
        [Required]
        public Guid Id { get; set; }

        [Required]
        public string OriginalName { get; set; }

        [Required]
        public string Director { get; set; }

        public string CommercialName { get; set; }

        public string Classification { get; set; }

        public string ImagePath { get; set; }

        public string Protagonists { get; set; }

        public int Duration { get; set; }
    }
}
