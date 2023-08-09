import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(
    private val passwordEncoder: BCryptPasswordEncoder
) {

    data class LoginRequest(val username: String, val password: String)

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ApiResponse<LoginResponse> {
        // Simulação: verifique o usuário e a senha com os detalhes do seu banco de dados
        val storedPasswordHash = passwordEncoder.encode("senha-secreta")
        if (request.username == "usuario" && passwordEncoder.matches(request.password, storedPasswordHash)) {
            val data = LoginResponse(text = "Login bem-sucedido!", number = 200, booleanValue = true)
            return ApiResponse(responseCode = 200, data = data)
        }
        val data = LoginResponse(text = "Falha no login!", number = 401, booleanValue = false)
        return ApiResponse(responseCode = 401, data = data)
    }
}