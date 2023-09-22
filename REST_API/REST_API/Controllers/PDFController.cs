using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.StaticFiles;

namespace REST_API.Controllers
{
    
    [ApiController]
    [Route("GeneratedPDFfromURL")]
    public class PDFController : ControllerBase
    {
        private async Task<ActionResult> DownloadFile (string filePath) 
        {
            var Downloadfilepath = Path.Combine(Directory.GetCurrentDirectory(), "GeneratedPdfFiles", filePath);

            var provider = new FileExtensionContentTypeProvider();
            if (!provider.TryGetContentType(Downloadfilepath, out var contentType)) 
            {
                contentType = "application/octet-stream";
            }
            var bytes = await System.IO.File.ReadAllBytesAsync(Downloadfilepath);
            return File(bytes, contentType, Path.GetFileName(Downloadfilepath));
        }

        [HttpGet]
        [Route("GeneratePDFfromURL")]
        public async Task<IActionResult> GeneratePDFfromURL(string URLlink)
        {
            var renderer = new ChromePdfRenderer();


            var pdf = renderer.RenderUrlAsPdf(URLlink);


            string PDFfilename = DateTime.Now.Ticks.ToString() + ".pdf";
            pdf.SaveAs(Path.Combine(Directory.GetCurrentDirectory(), "GeneratedPdfFiles", PDFfilename));

            return await DownloadFile(PDFfilename);
        }

    }
}
