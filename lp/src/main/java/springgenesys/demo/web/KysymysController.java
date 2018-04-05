package springgenesys.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springgenesys.demo.domain.Kysymykset;
import springgenesys.demo.domain.KysymyksetRepository;

@Controller
public class KysymysController {
	@Autowired
	KysymyksetRepository krepositrory;
	
	//REST
	@RequestMapping(value="/")
	public @ResponseBody List<Kysymykset> getKysymykset(){
		return (List<Kysymykset>) krepositrory.findAll(); 
		
	}
	
	
}
