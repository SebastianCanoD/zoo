package tecnm.com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tecnm.com.zoo.model.Alimentacion;
import tecnm.com.zoo.model.Salud;
import tecnm.com.zoo.model.Usuarios;
import tecnm.com.zoo.model.Visitantes;
import tecnm.com.zoo.repository.AlimentacionRepository;
import tecnm.com.zoo.repository.SaludRepository;
import tecnm.com.zoo.repository.UsuariosRepository;
import tecnm.com.zoo.repository.VisitantesRepository;
import tecnm.com.zoo.services.UsuariosService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsuariosService serviceUsuarios;

	@Autowired
	private SaludRepository repoSalud;

	@Autowired
	private AlimentacionRepository repoAlimentacion;

	@Autowired
	private VisitantesRepository repoVisitantes;

	@Autowired
	private UsuariosRepository usuarioRepository;

	@GetMapping("/inicioadmin")
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
		return "admin/inicioadmin";
	}

	@GetMapping("/usuariosadmin")
	public String mostrarUsuarios(Model model) {
		model.addAttribute("usuarios", serviceUsuarios.buscarUsuarios());
		model.addAttribute("nuevoUsuario", new Usuarios());
		return "/admin/usuariosadmin";
	}

	@PostMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute Usuarios usuarios) {
		serviceUsuarios.guardarUsuario(usuarios);
		return "redirect:/admin/usuariosadmin";
	}

	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(@PathVariable("id") int id_usuario, Model model) {
		model.addAttribute("nuevoUsuario", serviceUsuarios.buscarPorId(id_usuario));
		model.addAttribute("usuarios", serviceUsuarios.buscarUsuarios());
		return "/admin/usuariosadmin";
	}

	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable("id") int id_usuario) {
		serviceUsuarios.eliminarUsuario(id_usuario);
		return "redirect:/admin/usuariosadmin";
	}

	@GetMapping("/reportesadmin")
	public String mostrarReportes(Model model) {
		List<Salud> saludList = repoSalud.findAll();
		List<Alimentacion> alimentacionList = repoAlimentacion.findAll();
		List<Visitantes> visitanteList = repoVisitantes.findAll();

		model.addAttribute("saludList", saludList);
		model.addAttribute("alimentacionList", alimentacionList);
		model.addAttribute("visitanteList", visitanteList);

		return "/admin/reportesadmin";
	}
}
