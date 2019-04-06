using Demo.Models;
using Demo.Repository;
using Demo.ViewModels;
using NUnit.Framework;
using System.Collections.Generic;

namespace Demo.Tests
{
    [TestFixture]
    public class MainWindowViewModelTests
    {
        [Test]
        public void BasicMath()
        {
            var teachers = new List<Teacher>
            {
                new Teacher {Name = "t1"},
                new Teacher {Name = "t2"}
            };
            var vm = new MainWindowViewModel(new TestTeacherRepository(teachers));

            CollectionAssert.AreEqual(
                teachers, vm.Teachers);
        }

        private class TestTeacherRepository : ITeacherRepository
        {
            private readonly List<Teacher> _teachers;

            public TestTeacherRepository(List<Teacher> teachers)
            {
                _teachers = teachers;
            }

            public List<Teacher> GetTeachers()
            {
                return _teachers;
            }
        }
    }
}