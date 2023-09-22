using Microsoft.EntityFrameworkCore;
using REST_API;
using REST_API.Data;

var builder = WebApplication.CreateBuilder(args);



var app = Startup.InitializeApp(args);


app.Run();
