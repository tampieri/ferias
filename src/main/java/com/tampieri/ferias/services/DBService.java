package com.tampieri.ferias.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tampieri.ferias.domain.Endereco;
import com.tampieri.ferias.domain.Equipe;
import com.tampieri.ferias.domain.Funcionario;
import com.tampieri.ferias.domain.Signin;
import com.tampieri.ferias.repositories.EnderecoRepository;
import com.tampieri.ferias.repositories.EquipeRepository;
import com.tampieri.ferias.repositories.FeriasRepository;
import com.tampieri.ferias.repositories.FuncionarioRepository;
import com.tampieri.ferias.repositories.SigninRepository;

@Service
public class DBService {

	@Autowired
	private EquipeRepository equipeRepository;
	
	/*@Autowired
	private FeriasRepository feriasRepository;*/
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private SigninRepository signinRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTesDataBase() throws ParseException {
		
		Signin sig = new Signin(null, "administrador.ferias@castgroup.com.br", pe.encode("123a"));
		
		signinRepository.saveAll(Arrays.asList(sig));
		
		Equipe equ1 = new Equipe(null, "Desenvolvimento");
		Equipe equ2 = new Equipe(null, "Teste");
		
		equipeRepository.saveAll(Arrays.asList(equ1,equ2));
		
		Endereco end1 = new Endereco(null,"GPT1",551,"bl301","Camargos","BH","MG");
		Endereco end2 = new Endereco(null,"GPT2",552,"bl302","Camargos","BH","MG");
		Endereco end3 = new Endereco(null,"GPT3",553,"bl303","Camargos","BH","MG");
		Endereco end4 = new Endereco(null,"GPT4",554,"bl304","Camargos","BH","MG");
		
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3,end4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Funcionario fun1 = new Funcionario(null,"Higor T1",sdf.parse("19/06/1980 00:00"),end1,sdf.parse("19/06/2018 00:00"),null,equ1);
		Funcionario fun2 = new Funcionario(null,"Higor T2",sdf.parse("19/06/1980 00:00"),end2,sdf.parse("30/09/2018 00:00"),null,equ1);
		Funcionario fun3 = new Funcionario(null,"Higor T3",sdf.parse("19/06/1980 00:00"),end3,sdf.parse("30/09/2016 00:00"),null,equ1);
		Funcionario fun4 = new Funcionario(null,"Higor T4",sdf.parse("19/06/1980 00:00"),end4,sdf.parse("30/09/2015 00:00"),null,equ1);
		Funcionario fun5 = new Funcionario(null,"Higor T5",sdf.parse("19/06/1980 00:00"),end1,sdf.parse("30/06/2019 00:00"),null,equ2);
		Funcionario fun6 = new Funcionario(null,"Higor T6",sdf.parse("19/06/1980 00:00"),end2,sdf.parse("30/01/2018 00:00"),null,equ2);
		
		equ1.getFuncionarios().addAll(Arrays.asList(fun1,fun2,fun3,fun4));
		equ2.getFuncionarios().addAll(Arrays.asList(fun5,fun6));
		
		funcionarioRepository.saveAll(Arrays.asList(fun1,fun2,fun3,fun4,fun5,fun6));
		equipeRepository.saveAll(Arrays.asList(equ1,equ2));
	}
}
