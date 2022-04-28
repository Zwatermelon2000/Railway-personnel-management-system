package com.coding.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.coding.demo.result.Result;
import com.coding.demo.result.ResultFactory;
import com.coding.demo.util.AuthService;
import com.coding.demo.util.Base64Util;
import com.coding.demo.util.FileUtil;
import com.coding.demo.util.HttpUtil;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@RestController
@RequestMapping("/test")
public class UpLoadController {
	@Autowired
    JavaMailSender javaMailSender;   
    @PostMapping(value ="/upload" )
    public Object upload(@RequestParam("file")MultipartFile file){
        return generalBasic(file);
    }
    private static String saveFile(MultipartFile file) throws IOException{
       	File f = new File("");
    	String filePath = f.getCanonicalPath();
    	String directoryPath=filePath+"\\src\\file\\img";
        if (file.isEmpty()){
            return "未选择文件";
        }
        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
        File temp = new File(directoryPath);
        if (!temp.exists()){
            temp.mkdirs();
        }
        File localFile = new File(directoryPath+filename);
        System.out.println(localFile);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            System.out.println(file.getOriginalFilename()+" 上传成功");
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }
        System.out.println("local :"+localFile.getPath());
        return localFile.getPath();
    }
    public static String generalBasic(MultipartFile file) {
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        try {
            String filePath = saveFile(file) ;
            System.out.println("filep"+filePath);
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String accessToken = AuthService.getAuth("pFG7i5dkgBeaFrNlhPhAIrnM","AT9fKvI0xsNhNexeDGSSi8qrZ1cL7kEl");
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            delAllFile(filePath);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value ="/email" )
    public Result sendAttachFileMail(String email,String file) throws MessagingException, IOException {
    	File f = new File("");
		String filePath = f.getCanonicalPath();
		String directoryPath=filePath+"\\src\\file\\mail\\";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("12345铁路公司本月工资单");
        helper.setFrom("1958810573@qq.com");
        helper.setTo(email);
        helper.setSentDate(new Date());
        helper.setText("这是"+file.substring(0,12));
        helper.addAttachment("salary.xlsx",new File(directoryPath+file));
        try {
			Thread.currentThread();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        javaMailSender.send(mimeMessage);      
        delAllFile(directoryPath+file);
        return ResultFactory.buildSuccessResult("成功");
    }
    public static boolean delAllFile(String path) {
    	try{
            File file = new File(path);
            if(file.delete()){
                System.out.println(file.getName() + " 文件已被删除！");
            }
            else{
                System.out.println("文件删除失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
		return false;
    }
}