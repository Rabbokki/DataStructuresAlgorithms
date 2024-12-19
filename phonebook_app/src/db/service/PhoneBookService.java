package db.service;

import db.dto.TelBookDTO;
import db.repository.PhoneBookRepository;

import java.util.List;

public class PhoneBookService implements ServiceInterface{
    PhoneBookRepository bookRepository = new PhoneBookRepository();

    @Override
    public int insertService(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-insertService");
        return 0;
    }

    @Override
    public int updateService(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-updateService");
        return 0;
    }

    @Override
    public int deleteService(Long id) {
        System.out.println("[PhoneBookRepository]-deleteService");
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllListService() {
        System.out.println("[PhoneBookRepository]-getAllListService");
        return bookRepository.getAllList();
    }

    @Override
    public TelBookDTO findByIdService(Long id) {
        System.out.println("[PhoneBookRepository]-findByIdService");
        return null;
    }

    @Override
    public List<TelBookDTO> findByNameService(String name) {
        System.out.println("[PhoneBookRepository]-findByNameService");
        return null;
    }

    @Override
    public List<TelBookDTO> findByPhoneService(String phone) {
        System.out.println("[PhoneBookRepository]-findByPhoneService");
        return null;
    }
}
