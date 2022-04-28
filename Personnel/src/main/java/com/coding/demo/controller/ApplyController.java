package com.coding.demo.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coding.demo.result.Result;
import com.coding.demo.result.ResultFactory;
import com.coding.demo.service.ApplyService;
@RestController
@RequestMapping("/apply")
public class ApplyController {
	@Autowired
	private ApplyService applyService; 
	@RequestMapping("/transformation")
    public void transformation() throws IOException {	
		applyService.transformation();
	}
	@RequestMapping("/all")
    public Result pass(int isPass) throws IOException{	
		return ResultFactory.buildSuccessResult(applyService.all(isPass));
	}
	@RequestMapping("/update")
    public Result update(String id,int isPass) {	
		return ResultFactory.buildSuccessResult(applyService.isPass(id, isPass));
	}
    @RequestMapping(value = "/showPDF")
    public void pdfStreamHandler(String id,HttpServletRequest request, HttpServletResponse response) {
        File file = new File(applyService.showPDF(id).getEndFile());
        if (file.exists()) {
            byte[] data = null;
            FileInputStream input=null;
            try {
                input= new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
            } catch (Exception e) {
                System.out.println("pdf文件处理异常：" + e);
            }finally{
                try {
                    if(input!=null){
                        input.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
