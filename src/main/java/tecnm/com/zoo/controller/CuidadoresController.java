package tecnm.com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import tecnm.com.zoo.model.Alimentacion;
import tecnm.com.zoo.model.Animales;
import tecnm.com.zoo.model.Cuidadores;
import tecnm.com.zoo.model.Especies;
import tecnm.com.zoo.model.Habitats;
import tecnm.com.zoo.model.Salud;
import tecnm.com.zoo.model.Usuarios;
import tecnm.com.zoo.repository.UsuariosRepository;
import tecnm.com.zoo.services.AlimentacionService;
import tecnm.com.zoo.services.AnimalesService;
import tecnm.com.zoo.services.CuidadoresService;
import tecnm.com.zoo.services.EspeciesService;
import tecnm.com.zoo.services.HabitatsService;
import tecnm.com.zoo.services.SaludService;

@Controller
@RequestMapping("/cuidadores")
public class CuidadoresController {

	@Autowired
	private AnimalesService serviceAnimales;

	@Autowired
	private EspeciesService serviceEspecies;

	@Autowired
	private HabitatsService serviceHabitats;

	@Autowired
	private AlimentacionService serviceAlimentacion;

	@Autowired
	private CuidadoresService serviceCuidadores;

	@Autowired
	private SaludService serviceSalud;

	@Autowired
	private UsuariosRepository usuarioRepository;

	@GetMapping("/iniciocuidador")
	public String mostrarInicio(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		// Buscar el usuario por username
		Usuarios usuario = usuarioRepository.findByUsername(username);

		if (usuario != null) {
			model.addAttribute("usuario", usuario.getNombre());
			model.addAttribute("rol", usuario.getRol());
		} else {
			model.addAttribute("usuario", "Invitado");
			model.addAttribute("rol", "ROLE_ANONYMOUS");
		}
		return "cuidador/iniciocuidador";
	}

	@GetMapping("/animalescuidador")
	public String mostrarFormulario(Model model) {
		model.addAttribute("animales", serviceAnimales.buscarAnimales());
		model.addAttribute("especies", serviceEspecies.obtenerTodas());
		model.addAttribute("habitats", serviceHabitats.buscarHabitats());
		model.addAttribute("cuidadores", serviceCuidadores.buscarCuidadores());
		model.addAttribute("nuevoAnimal", new Animales());
		return "cuidador/animalescuidador";
	}

	@GetMapping("/alimentacioncuidador")
	public String gestionAlimentacion(Model model) {
		model.addAttribute("alimentacion", new Alimentacion());
		model.addAttribute("alimentaciones", serviceAlimentacion.buscarAlimentacion());
		model.addAttribute("animales", serviceAnimales.buscarAnimales());
		return "cuidador/alimentacioncuidador";
	}

	@GetMapping("/editaranimal/{id}")
	public String editarAnimal(@PathVariable("id") int id_animal, Model model, RedirectAttributes redirectAttributes) {

		try {
			// Buscar el animal por ID
			Animales animales = serviceAnimales.buscarPorId(id_animal);

			// Verificar si el animal existe
			if (animales == null) {
				redirectAttributes.addFlashAttribute("error", "No se encontró el animal con ID: " + id_animal);
				return "redirect:/cuidadores/animalescuidador";
			}

			// Agregar los datos necesarios al modelo
			model.addAttribute("nuevoAnimal", animales); // Usando "nuevoAnimal" para consistencia
			model.addAttribute("especies", serviceEspecies.obtenerTodas());
			model.addAttribute("habitats", serviceHabitats.buscarHabitats());
			model.addAttribute("cuidadores", serviceCuidadores.buscarCuidadores());

			return "cuidador/editaranimalescuidador"; // Vista específica para edición

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al cargar el animal: " + e.getMessage());
			return "redirect:/cuidadores/animalescuidador";
		}
	}

	@GetMapping("/especiescuidador")
	public String gestionEspecies(Model model) {
		List<Especies> listaEspecies = serviceEspecies.buscarEspecies();
		model.addAttribute("especies", listaEspecies);
		return "cuidador/especiescuidador";
	}

	@GetMapping("/habitatscuidador")
	public String gestionHabitats(Model model) {
		List<Habitats> listaHabitats = serviceHabitats.buscarHabitats();
		model.addAttribute("habitats", listaHabitats);
		return "cuidador/habitatscuidador";
	}

	@GetMapping("/saludcuidador")
	public String gestionSalud(Model model) {
		List<Salud> listaSalud = serviceSalud.buscarSalud();
		model.addAttribute("salud", listaSalud);

		List<Animales> listaAnimales = serviceAnimales.buscarAnimales();
		List<Cuidadores> listaCuidadores = serviceCuidadores.buscarCuidadores();

		model.addAttribute("saludForm", new Salud());
		model.addAttribute("animales", listaAnimales);
		model.addAttribute("cuidadores", listaCuidadores);

		return "cuidador/saludcuidador";
	}

	@PostMapping("/agregarsalud")
	public String agregarsalud(@ModelAttribute Salud salud, BindingResult result, RedirectAttributes atributos,
			@RequestParam(value = "id_reporte", required = false) Integer id_reporte, @RequestParam String accion) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrió un error: " + error.getDefaultMessage());
			}
			return "cuidador/saludcuidador";
		}

		switch (accion) {
		case "agregar":
			serviceSalud.guardarSalud(salud);
			atributos.addFlashAttribute("msg", "Reporte de salud agregado correctamente. 😊");
			System.out.println("Nuevo reporte de salud agregado: " + salud);
			break;
		case "modificar":
			serviceSalud.guardarSalud(salud);
			atributos.addFlashAttribute("msg", "Reporte de salud modificado correctamente. 😊");
			System.out.println("Reporte de salud modificado: " + salud);
			break;
		case "eliminar":
			if (id_reporte != null) {
				serviceSalud.eliminarSalud(id_reporte);
				atributos.addFlashAttribute("msg", "Reporte de salud eliminado correctamente. 😊");
				System.out.println("Reporte de salud eliminado - ID: " + id_reporte);
			} else {
				atributos.addFlashAttribute("error", "ID inválido para eliminar.");
			}
			break;
		default:
			atributos.addFlashAttribute("msg", "Acción no reconocida.");
			break;
		}

		return "redirect:saludcuidador";
	}

	@PostMapping("/agregaranimal")
	public String guardarAnimal(@ModelAttribute("nuevoAnimal") @Valid Animales animales, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam String accion) {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.nuevoAnimal", result);
			redirectAttributes.addFlashAttribute("nuevoAnimal", animales);
			return "redirect:/cuidadores/animalescuidador";
		}

		switch (accion) {
		case "agregar":
			serviceAnimales.guardarAnimal(animales);
			redirectAttributes.addFlashAttribute("msg", "Animal agregado correctamente. 😊");
			System.out.println("Nuevo animal agregado: " + animales);
			break;
		case "modificar":
			serviceAnimales.guardarAnimal(animales);
			redirectAttributes.addFlashAttribute("msg", "Animal modificado correctamente. 😊");
			System.out.println("Animal modificado: " + animales);
			break;
		case "eliminar":
			Integer idAnimal = animales.getId_animal();
			serviceAnimales.eliminarAnimal(idAnimal);
			redirectAttributes.addFlashAttribute("msg", "Animal eliminado correctamente. 😊");
			System.out.println("Animal eliminado - ID: " + idAnimal);
			break;
		default:
			redirectAttributes.addFlashAttribute("msg", "Acción no reconocida.");
			System.out.println("Acción desconocida: " + accion);
			break;
		}

		return "redirect:/cuidadores/animalescuidador";
	}

	@PostMapping("/agregarespecie")
	public String guardarEspecie(@ModelAttribute Especies especies, BindingResult result, RedirectAttributes atributos,
			@RequestParam String accion) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrió un error: " + error.getDefaultMessage());
			}
			return "cuidador/especiescuidador";
		}

		switch (accion) {
		case "agregar":
			serviceEspecies.guardarEspecie(especies);
			atributos.addFlashAttribute("msg", "Especie agregada correctamente. 😊");
			System.out.println("Nueva especie agregada: " + especies);
			break;
		case "modificar":
			serviceEspecies.guardarEspecie(especies);
			atributos.addFlashAttribute("msg", "Especie modificada correctamente. 😊");
			System.out.println("Especie modificada: " + especies);
			break;
		case "eliminar":
			Integer idEspecie = especies.getId_especie();
			serviceEspecies.eliminarEspecie(idEspecie);
			atributos.addFlashAttribute("msg", "Especie eliminada correctamente. 😊");
			System.out.println("Especie eliminada - ID: " + idEspecie);
			break;
		default:
			atributos.addFlashAttribute("msg", "Acción no reconocida.");
			break;
		}

		return "redirect:especiescuidador";
	}

	@PostMapping("/agregarhabitat")
	public String guardarHabitat(@ModelAttribute Habitats habitats, BindingResult result, RedirectAttributes atributos,
			@RequestParam String accion) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "cuidador/habitatscuidador";
		}

		switch (accion) {
		case "agregar":
			serviceHabitats.guardarHabitat(habitats);
			atributos.addFlashAttribute("msg", "Hábitat agregada correctamente. 😊");
			System.out.println("Nueva hábitat agregada: " + habitats);
			break;
		case "modificar":
			serviceHabitats.guardarHabitat(habitats);
			atributos.addFlashAttribute("msg", "Hábitat modificada correctamente. 😊");
			System.out.println("Hábitat modificada: " + habitats);
			break;
		case "eliminar":
			Integer idHabitat = habitats.getId_habitat();
			serviceHabitats.eliminarHabitat(idHabitat);
			atributos.addFlashAttribute("msg", "Hábitat eliminada correctamente. 😊");
			System.out.println("Hábitat eliminada - ID: " + idHabitat);
			break;
		default:
			atributos.addFlashAttribute("msg", "Acción no reconocida.");
			break;
		}

		return "redirect:habitatscuidador";
	}

	@PostMapping("/agregaralimentacion")
	public String guardarAlimentacion(@ModelAttribute Alimentacion alimentacion, BindingResult result,
			RedirectAttributes atributos, @RequestParam String accion) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrió un error: " + error.getDefaultMessage());
			}
			return "cuidador/alimentacioncuidador"; // Página de formulario con errores
		}

		switch (accion) {
		case "agregar":
			serviceAlimentacion.guardarAlimentacion(alimentacion);
			atributos.addFlashAttribute("msg", "Alimentación agregada correctamente. 😊");
			System.out.println("Nueva alimentación agregada: " + alimentacion);
			break;
		case "modificar":
			serviceAlimentacion.guardarAlimentacion(alimentacion);
			atributos.addFlashAttribute("msg", "Alimentación modificada correctamente. 😊");
			System.out.println("Alimentación modificada: " + alimentacion);
			break;
		case "eliminar":
			Integer idAlimentacion = alimentacion.getId_alimentacion();
			serviceAlimentacion.eliminarAlimentacion(idAlimentacion);
			atributos.addFlashAttribute("msg", "Alimentación eliminada correctamente. 😊");
			System.out.println("Alimentación eliminada - ID: " + idAlimentacion);
			break;
		default:
			atributos.addFlashAttribute("msg", "Acción no reconocida.");
			break;
		}

		return "redirect:/cuidadores/alimentacioncuidador";
	}

	@GetMapping("/eliminarhabitat/{id}")
	public String eliminarHabitat(@PathVariable("id") Integer id_habitat, RedirectAttributes atributos) {
		serviceHabitats.eliminarHabitat(id_habitat);
		atributos.addFlashAttribute("msg", "Hábitat eliminada correctamente. 😊");
		return "cuidador/iniciocuidador";
	}

	@GetMapping("/eliminaralimentacion/{id}")
	public String eliminarAlimentacion(@PathVariable("id") Integer id_alimentacion, RedirectAttributes atributos) {
		serviceAlimentacion.eliminarAlimentacion(id_alimentacion);
		atributos.addFlashAttribute("msg", "Alimentación eliminada correctamente. 😊");
		return "cuidador/iniciocuidador";
	}

	@GetMapping("/eliminarespecie/{id}")
	public String eliminarEspecie(@PathVariable("id") Integer id_especie, RedirectAttributes atributos) {
		serviceEspecies.eliminarEspecie(id_especie);
		atributos.addFlashAttribute("msg", "Especie eliminada correctamente. 😊");
		return "cuidador/iniciocuidador";
	}

	@PostMapping("/eliminaranimal/{id}")
	public String eliminarAnimal(@PathVariable("id") int idAnimal, RedirectAttributes atributos) {
		try {
			serviceAnimales.eliminarAnimal(idAnimal);
			atributos.addFlashAttribute("msg", "Animal eliminado correctamente.");
		} catch (Exception e) {
			atributos.addFlashAttribute("error", "Error al eliminar el animal: " + e.getMessage());
		}
		return "redirect:/cuidadores/animalescuidador";
	}
}
