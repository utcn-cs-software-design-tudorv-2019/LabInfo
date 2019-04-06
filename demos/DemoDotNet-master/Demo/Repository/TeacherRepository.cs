using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using Demo.DataAccess;
using Demo.Models;

namespace Demo.Repository
{
    public class TeacherRepository : ITeacherRepository
    {
        private readonly LiveCodingContext _context;

        public TeacherRepository(LiveCodingContext context)
        {
            _context = context;
        }

        public List<Teacher> GetTeachers()
        {
            return _context.Teachers.Include(t => t.Courses).ToList();
        }
    }
}