package db.service;

import db.dto.SearchResultDTO;
import db.dto.TelBookDTO;
import db.repository.PhoneBookRepository;

import java.util.List;

public class PhoneBookService implements ServiceInterface{
    PhoneBookRepository bookRepository = new PhoneBookRepository();

    @Override
    public int insertService(TelBookDTO dto) {
        return bookRepository.insertData(dto);
    }

    @Override
    public int updateService(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-updateService");
        return bookRepository.updateData(dto);
    }

    @Override
    public int deleteService(Long id) {
        System.out.println("[PhoneBookRepository]-deleteService");
        return bookRepository.deleteData(id);
    }

    @Override
    public List<TelBookDTO> getAllListService() {
        System.out.println("[PhoneBookRepository]-getAllListService");
        return bookRepository.getAllList();
    }

    @Override
    public TelBookDTO findByIdService(Long id) {
//        System.out.println("[PhoneBookService]-findByIdService");
        return bookRepository.findById(id);
    }

    @Override
    public List<SearchResultDTO> findByNameService(String name) {
        System.out.println("[PhoneBookRepository]-findByNameService");
        return bookRepository.findByName(name);
    }

    @Override
    public List<SearchResultDTO> findByPhoneService(String phone) {
        System.out.println("[PhoneBookRepository]-findByPhoneService");
        return bookRepository.findByPhone(phone);
    }
}
