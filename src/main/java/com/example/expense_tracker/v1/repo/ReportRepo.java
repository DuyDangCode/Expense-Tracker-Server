import com.example.expense_tracker.v1.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<ReportModel, Long> {
}
