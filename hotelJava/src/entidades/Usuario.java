package entidades;

import java.util.Scanner;

public class Usuario {
    static Scanner input = new Scanner(System.in);
    
    protected String email;
    protected String nome;
    protected String senha;
    protected Boolean autenticado;

    public Usuario(){
        super();
    }

    public Usuario(String email, String nome, String senha){
        super();
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.autenticado = false;
    }
    
    public String getEmail(){
        return this.email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSenha(){
        return this.senha;
    }

    public Boolean isAutenticado(){
        return this.autenticado;
    }

    public void autenticar(String senha) {
        if (this.senha.equals(senha)) {
            autenticado = true;
        }
    }

    public static Usuario[] cadastrarUsuario(Usuario[] arrayUsuarios, int quantidadeUsuarios){
        System.out.println("Abrindo conta...");
        System.out.println("- Informe seu email");
        String email = input.nextLine();
        // verificando se já existe o email no array
        
    	System.out.println("- Informe seu nome");
    	String nome = input.nextLine();
    	System.out.println("- Digite sua senha");
    	String senha = input.nextLine();
    			
    	Usuario novoUsuario = new Usuario(email, nome, senha);
    			
    	if (arrayUsuarios.length == quantidadeUsuarios) {
    		Usuario[] novoArray = new Usuario[arrayUsuarios.length + 1];
    		System.arraycopy(arrayUsuarios, 0, novoArray, 0, arrayUsuarios.length);
    		arrayUsuarios = novoArray;
    	}
    			
    	arrayUsuarios[quantidadeUsuarios] = novoUsuario;
        quantidadeUsuarios++;
    			
    	System.out.println("Conta criada com sucesso!\n");
        return arrayUsuarios;
    }

    public static Usuario realizarLogin(Usuario[] arrayUsuarios){
        System.out.println("Logando...");
    	Usuario login = new Usuario();
    	System.out.println("Informe seu email: ");
    	String email = input.nextLine();
    			
    	for (Usuario usuario: arrayUsuarios) {
    		if (usuario.getEmail().equals(email)) {
    			login = usuario;
    		}
    	}
    			
    	if (login.getNome() == null) {
    		System.out.println("Usuário não encontrado.");
            return null;
    	}
    			
    	System.out.println("Senha: ");
    	String senhaLogin = input.nextLine();
    			
    	login.autenticar(senhaLogin); //verificando se as senhas correspondem
    			
    	if (login.isAutenticado()) {
			System.out.println("Seja bem vindo " + login.getNome() +"!");
			return login;
		} else {
			System.out.println("Senha incorreta.");
            return null;
		}

    }

    public void deslogar(){
        this.autenticado = false;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "email=" + email +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", autenticado=" + autenticado +
                '}';
    }
}
