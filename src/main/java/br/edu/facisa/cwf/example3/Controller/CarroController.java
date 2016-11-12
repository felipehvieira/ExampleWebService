package br.edu.facisa.cwf.example3.Controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.facisa.cwf.example3.Model.Carro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CarroController {
	
	@RequestMapping(value="/carro", method = RequestMethod.GET)
	public ResponseEntity<List<Carro>> listAllCars(){
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(new Carro(1,"Chevrolet","Prisma"));
		carros.add(new Carro(2,"Nissan","Versa"));

		return new ResponseEntity<List<Carro>>(carros,HttpStatus.OK);
		
	}
	@RequestMapping(value = "/carro", method = RequestMethod.POST)
	public ResponseEntity<Carro> criaCarro(@RequestBody Carro carro){

		try {
			return new ResponseEntity<Carro>(carro,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Carro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/carro/{id}")
	public ResponseEntity<Carro> getCarro(@PathVariable int id){
		Carro carro = new Carro(1,"Nissan","Versa");
		
		
		return carro.getId() == id ?  
					new ResponseEntity<Carro>(carro, HttpStatus.OK):
						new ResponseEntity<Carro>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/carro/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Carro> updateCarro(@PathVariable int id, @RequestBody Carro carro){
		Carro carro2 = new Carro(1,"Nissan","Versa");
		
		carro2.setId(id);
		carro2.setMarca(carro.getMarca());
		carro2.setModelo(carro.getModelo());
		return new ResponseEntity<Carro>(carro2, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/carro/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Carro> deleteCarro(@PathVariable int id){
		
		return new ResponseEntity<Carro>(HttpStatus.OK);
	}

}
