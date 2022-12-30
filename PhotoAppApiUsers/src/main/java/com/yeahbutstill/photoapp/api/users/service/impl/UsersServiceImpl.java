package com.yeahbutstill.photoapp.api.users.service.impl;

import com.yeahbutstill.photoapp.api.users.data.AlbumsServiceClient;
import com.yeahbutstill.photoapp.api.users.data.UserEntity;
import com.yeahbutstill.photoapp.api.users.data.UsersRepository;
import com.yeahbutstill.photoapp.api.users.model.response.AlbumResponseModel;
import com.yeahbutstill.photoapp.api.users.service.UsersService;
import com.yeahbutstill.photoapp.api.users.shared.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {
	
	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	//RestTemplate restTemplate;
	Environment environment;
	AlbumsServiceClient albumsServiceClient;
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			AlbumsServiceClient albumsServiceClient, Environment environment) {

		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.albumsServiceClient = albumsServiceClient;
		this.environment = environment;

	}
 
	@Override
	public UserDto createUser(UserDto userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		
		ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

		usersRepository.save(userEntity);

		return modelMapper.map(userEntity, UserDto.class);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = usersRepository.findByEmail(username);
		if(userEntity == null) throw new UsernameNotFoundException(username);	
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),
				true,
				true,
				true,
				true,
				new ArrayList<>());

	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {

		UserEntity userEntity = usersRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		return new ModelMapper().map(userEntity, UserDto.class);

	}

	@Override
	public UserDto getUserByUserId(String userId) {
		
        UserEntity userEntity = usersRepository.findByUserId(userId);     
        if(userEntity == null) throw new UsernameNotFoundException("User not found");

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
        
        /*
        String albumsUrl = String.format(environment.getProperty("albums.url"), userId);
        
        ResponseEntity<List<AlbumResponseModel>> albumsListResponse = restTemplate.exchange(albumsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumResponseModel>>() {
        });
        List<AlbumResponseModel> albumsList = albumsListResponse.getBody(); 
        */
        
        log.info("Before calling albums Microservice");
        List<AlbumResponseModel> albumsList = albumsServiceClient.getAlbums(userId);
        log.info("After calling albums Microservice");
        
		userDto.setAlbums(albumsList);
		
		return userDto;

	}

}
