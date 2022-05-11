package com.generation.lojadegames.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.lojadegames.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(Usuario usuario) { // método construtor com parâmetros
		this.userName = usuario.getUsuario();
		this.password = usuario.getSenha();
	}

	public UserDetailsImpl() {
	} // método construtor sem parâmetros

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // método que retorna as Autorizações da conta do usuário
																		
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {

		return userName;
	}

	@Override
	public boolean isAccountNonExpired() { // método que Indica se a conta do usuário expirou.
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // método que Indica se o usuário está bloqueado ou desbloqueado.
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // método que indica se as credenciais do usuário (senha) expiraram.
		return true;
	}

	@Override
	public boolean isEnabled() { // método que Indica se o usuário está habilitado ou desabilitado, se mudar para
								// false nenhum usuário conseguirá logar.
		return true;
	}

}
