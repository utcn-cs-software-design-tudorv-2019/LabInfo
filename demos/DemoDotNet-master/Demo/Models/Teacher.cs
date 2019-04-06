using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;

namespace Demo.Models
{
    public class Teacher
    {
        [Key]
        public int Id { get; set; }

        public string Name { get; set; }

        public List<Course> Courses { get; set; }

        public override string ToString()
        {
            return Name + " nr. of courses: " + string.Join(", ", (Courses?? new List<Course>()).Select(c => c.Name));
        }
    }
}
