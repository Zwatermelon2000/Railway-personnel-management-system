package com.coding.demo.service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.coding.demo.entity.Apply;
import com.coding.demo.mapper.ApplyMapper;
@Service
public class ApplyService {
	@Autowired
	public ApplyMapper applyMapper;
	public void transformation() throws IOException {
		String id;
		File f = new File("");
		String filePath = f.getCanonicalPath();
		String directoryPath=filePath+"\\src\\file\\docx";
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
        	return ;
        }
        OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
		connection.connect();
        File[] files = baseFile.listFiles();
        for(File file : files) {
        	if(applyMapper.selectAll().size()==0) {
    			id="100001";
    		}
    		else {			  
                id=String.valueOf(Integer.valueOf(applyMapper.selectAll().get(applyMapper.selectAll().size()-1).getId())+1);
    		}
        	BasicFileAttributes bAttributes = null;
            try {
                bAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName=file.getName();
            String name = fileName.substring(0,fileName.lastIndexOf("."));
            Instant instant =bAttributes.creationTime().toInstant();
            String format = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(instant);
            String firstFile=file.getAbsolutePath().replace("\\","\\\\");
        	String endFile=firstFile.replace("docx","pdf");
        	File inputFile = new File(firstFile);
        	File outputFile = new File(endFile);
        	DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			converter.convert(inputFile, outputFile);
            applyMapper.insertFile(firstFile,id,format,endFile,name);
        }    
    	connection.disconnect();				
		System.out.println("转换完成！");
	}
	public List<Apply> all(int isPass) {
		return applyMapper.all(isPass);
	}
	public int isPass(String id,int isPass) {
		return applyMapper.isPass(id,isPass);
	}
	public Apply showPDF(String id) {
		return applyMapper.showPDF(id);
	}
}
