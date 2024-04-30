package entidades;

import hotelJava.Quarto;

public class Cliente extends Usuario{
    private Quarto quartoAlugado;

    public Cliente(){}

    public Cliente(String email, String nome, String senha, Quarto quartoAlugado) {
        super(email, nome, senha);
        this.quartoAlugado = quartoAlugado;
    }

    public Quarto getQuartoAlugado() {
        return quartoAlugado;
    }

    public void setQuartoAlugado(Quarto quartoAlugado) {
        this.quartoAlugado = quartoAlugado;
    }

    public static Cliente[] cadastrarUsuario(Cliente[] arrayClientes, int quantidadeClientes){
        System.out.println("Abrindo conta...");
        System.out.println("- Informe seu email");
        String email = input.nextLine();
        
        for (int i = 0; i!=arrayClientes.length;i++) {
        	while (arrayClientes[i]!= null && email.equals(arrayClientes[i].email)) {
        		System.out.println("Email já existente! Por favor, insira outro email ou logue em sua conta!");
        		email = input.nextLine();
        		System.out.println(" ");
        	}
        }
        
    	System.out.println("- Informe seu nome");
    	String nome = input.nextLine();
    	
    	System.out.println("- Digite sua senha");
    	String senha = input.nextLine();
    			
    	Cliente novoCliente = new Cliente(email, nome, senha, null);
    			
    	if (arrayClientes.length == quantidadeClientes) {
    		Cliente[] novoArray = new Cliente[arrayClientes.length + 1];
    		System.arraycopy(arrayClientes, 0, novoArray, 0, arrayClientes.length);
    		arrayClientes = novoArray;
    	}
    			
    	arrayClientes[quantidadeClientes] = novoCliente;
        
    			
    	System.out.println("Conta criada com sucesso!\n");
        return arrayClientes;
    }

    public static Cliente realizarLogin(Cliente[] arrayClientes){
        System.out.println("Logando...");
    	Cliente login = new Cliente();
    	System.out.println("Informe seu email: ");
    	String email = input.nextLine();
    			
    	for (Cliente cliente: arrayClientes) {
    		if (cliente.getEmail().equals(email)) {
    			login = cliente;
    		}
    	}
    			
    	if (login.getEmail() == null) {
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
    
    public static boolean verificarQuartoAlugado(Cliente login) {
    	if (login.quartoAlugado!=null) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public String toString() {
    	
    	String numQuarto = "";
    	
    	if(quartoAlugado == null) {
			numQuarto = "Ainda nao possui quartos alugados!";
		}
    	else{
    		numQuarto += quartoAlugado.getNumQuarto();
    	}
    	
        return "\n" + "Dados do Usuario:" + "\n" +
                "E-mail: " + email + "\n" +
                "Nome: " + nome + "\n" +
                "Quarto alugado: " + numQuarto + "\n";
        		
    }
}

