package lokesh.springframework.spring5webapp.respositories;

import lokesh.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {


}
