using System.Windows;
using Demo.DataAccess;
using Demo.Repository;
using Demo.ViewModels;

namespace Demo
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            DataContext = new MainWindowViewModel(
                new TeacherRepository(
                    new LiveCodingContext()));
        }
    }
}
