using System.Collections.Generic;
using Demo.Models;

namespace Demo.Repository
{
    public interface ITeacherRepository
    {
        List<Teacher> GetTeachers();
    }
}
