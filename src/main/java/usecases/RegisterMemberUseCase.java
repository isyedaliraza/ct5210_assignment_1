package usecases;

import adapters.LibraryRepository;
import entities.Member;

public class RegisterMemberUseCase {
    private final LibraryRepository repository;

    public RegisterMemberUseCase(LibraryRepository repository) {
        this.repository = repository;
    }

    public void registerMember(Member member) {
        this.repository.registerMember(member);
    }
}
