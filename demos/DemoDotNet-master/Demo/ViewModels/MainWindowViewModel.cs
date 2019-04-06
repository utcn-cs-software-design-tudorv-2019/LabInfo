using System.Collections.Generic;
using Demo.Models;
using Demo.Repository;

namespace Demo.ViewModels
{
    public class MainWindowViewModel
    {
        public MainWindowViewModel(
            ITeacherRepository teacherRepository)
        {
                Teachers = teacherRepository.GetTeachers();
        }
        public List<Teacher> Teachers { get; set; }
    }
}
