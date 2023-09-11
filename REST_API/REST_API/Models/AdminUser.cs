using System.ComponentModel.DataAnnotations;

namespace REST_API.Models
{
    public class AdminUser
    {
        [Key]
        [Required]
        public string Username { get; set; }

        [Required]
        public string Password { get; set; }

        public string FullName { get; set; }
    }
}
