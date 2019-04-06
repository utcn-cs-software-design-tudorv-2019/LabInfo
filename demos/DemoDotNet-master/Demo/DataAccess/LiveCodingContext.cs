using System.Data.Entity;
using Demo.Models;
using SQLite.CodeFirst;

namespace Demo.DataAccess
{
    public class LiveCodingContext : DbContext
    {
        public LiveCodingContext()
            : base("LiveCodingContext")
        {
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            var sqliteConnectionInitializer = new LiveCodingContextInitializer(modelBuilder);
            Database.SetInitializer(sqliteConnectionInitializer);
        }

        public IDbSet<Teacher> Teachers { get; set; }
        public IDbSet<Course> Courses { get; set; }
    }

    public class LiveCodingContextInitializer : SqliteDropCreateDatabaseAlways<LiveCodingContext>
    {
        public LiveCodingContextInitializer(DbModelBuilder modelBuilder)
            : base(modelBuilder)
        {
            modelBuilder
                .Entity<Course>()
                .HasRequired(c => c.Teacher)
                .WithMany(t => t.Courses);
            //.HasForeignKey(c => c.TeacherId);
        }

        protected override void Seed(LiveCodingContext context)
        {
            Teacher teacher1 = new Teacher
            {
                Name = "Teacher 1"
            };

            Teacher teacher2 = new Teacher
            {
                Name = "Teacher 2"
            };

            Course c1 = new Course
            {
                Name = "Course 1",
                Teacher = teacher1
            };

            Course c2 = new Course
            {
                Name = "Course 2",
                Teacher = teacher2
            };

            Course c3 = new Course
            {
                Name = "Course 3",
                Teacher = teacher2
            };
            
            context.Set<Teacher>().Add(teacher1);
            context.Set<Teacher>().Add(teacher2);

            context.Set<Course>().Add(c1);
            context.Set<Course>().Add(c2);
            context.Set<Course>().Add(c3);
        }
    }
}
