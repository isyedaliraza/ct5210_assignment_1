package usecases;

import adapters.LibraryRepository;
import entities.Member;

import java.util.ArrayList;

public class ListMembersUseCase {

    private final LibraryRepository repository;

    public ListMembersUseCase(LibraryRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Member> listMembers() {
        return this.repository.listMembers();
    }
}
