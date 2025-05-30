package tecnm.com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import tecnm.com.zoo.model.Animales;
import tecnm.com.zoo.model.Especies;
import tecnm.com.zoo.model.Habitats;
import tecnm.com.zoo.services.AnimalesService;
import tecnm.com.zoo.services.CuidadoresService;
import tecnm.com.zoo.services.EspeciesService;
import tecnm.com.zoo.services.HabitatsService;

@Controller
public class HomeController {

	@Autowired
	private AnimalesService serviceAnimales;

	@Autowired
	private CuidadoresService serviceCuidadores;

	@Autowired
	private HabitatsService serviceHabitats;

	@Autowired
	private EspeciesService serviceEspecies;

	@GetMapping("/")
	public String mostrarInicio(Model model) {

		return "iniciozoo";
	}

	@GetMapping("/animales")
	public String mostrarAnimales(Model model) {
		model.addAttribute("animales", serviceAnimales.buscarAnimales());
		return "animales";
	}

	@GetMapping("/especies")
	public String mostrarEspecies(Model model) {
		model.addAttribute("especies", serviceEspecies.buscarEspecies());
		return "especies";
	}

	@GetMapping("/habitats")
	public String mostrarHabitats(Model model) {
		model.addAttribute("habitats", serviceHabitats.buscarHabitats());
		return "habitats";
	}

	@GetMapping("/cuidadores")
	public String mostrarCuidadores(Model model) {
		model.addAttribute("cuidadores", serviceCuidadores.buscarCuidadores());
		return "cuidadores";
	}

	@GetMapping("/detalleanimal/{id}")
	public String mostrarDetalleAnimal(@PathVariable("id") Integer id_animal, Model model) {
		model.addAttribute("animal", serviceAnimales.buscarPorId(id_animal));
		return "detalleanimal";
	}

	@GetMapping("/mapa")
	public String mostrarMapa(Model model) {
		return "mapa";
	}

	@GetMapping("/buscar")
	public String buscarAnimal(@RequestParam(required = false) String nombre, Model model) {
		List<Animales> animales;

		if (nombre != null && !nombre.isEmpty()) {
			animales = serviceAnimales.buscarPorNombre(nombre);
		} else if (nombre != null && !nombre.isEmpty()) {
			animales = serviceAnimales.buscarPorNombre(nombre);
		} else {
			animales = serviceAnimales.buscarAnimales();
		}

		model.addAttribute("animales", animales);
		return "animales";
	}

	@GetMapping("/buscarEspecie")
	public String buscarEspecie(@RequestParam(required = false) String clase, Model model) {
		List<Especies> especies = null;

		if (clase != null && !clase.isEmpty()) {
			especies = serviceEspecies.buscarEspecies();
		}

		model.addAttribute("especies", especies);
		return "especies";
	}

	@GetMapping("/buscarHabitat")
	public String buscarHabitat(@RequestParam(required = false) String nombre, Model model) {
		List<Habitats> habitats;

		if (nombre != null && !nombre.isEmpty()) {
			habitats = serviceHabitats.buscarPorNombre(nombre);
		} else if (nombre != null && !nombre.isEmpty()) {
			habitats = serviceHabitats.buscarPorNombre(nombre);
		} else {
			habitats = serviceHabitats.buscarHabitats();
		}

		model.addAttribute("habitats", habitats);
		return "habitats";
	}

	@GetMapping("/login")
	public String mostrarLogin(Model model) {
		return "login";
	}

	@GetMapping("/logout")
	public String ejecutarLogout() {
		return "redirect:/login?logout";
	}

}
