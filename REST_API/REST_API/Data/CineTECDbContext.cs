using Microsoft.EntityFrameworkCore;
using REST_API.Models;

namespace REST_API.Data
{
    public class CineTECDbContext : DbContext
    {
        public CineTECDbContext(DbContextOptions options) : base(options)
        {
        }

        public DbSet<AdminUser> Admins { get; set; }

        public DbSet<BranchOffice> BranchOffices { get; set; }

        public DbSet<Room> Rooms { get; set; }

        public DbSet<Projection> Projections { get; set; }

        public DbSet<Movie> Movies { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Setting up the Room - BranchOffice relationship
            modelBuilder.Entity<Room>()
                .HasOne(r => r.BranchOffice)        // A room has a branch
                .WithMany(b => b.Rooms)             // A branch has many rooms
                .HasForeignKey(r => r.Branch_Id)    // Room foreign key
                .IsRequired();

            // Setting up the Room - Projection relationship
            modelBuilder.Entity<Projection>()
                .HasOne(p => p.Room)              // A projection has a room
                .WithMany(r => r.Projections)       // A room has many projections
                .HasForeignKey(p => p.Room_Id)    // Projection Foreign Key
                .IsRequired();
        }
    }
}
