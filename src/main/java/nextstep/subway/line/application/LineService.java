package nextstep.subway.line.application;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.LineRepository;
import nextstep.subway.line.dto.LineRequest;
import nextstep.subway.line.dto.LineResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LineService {
    private LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public LineResponse saveLine(LineRequest request) {
        Line persistLine = lineRepository.save(request.toLine());
        return LineResponse.of(persistLine);
    }

    public LineResponse update(Long id, LineRequest lineRequest) {
        Line line = findEntityById(id);

        line.update(lineRequest.toLine());

        return LineResponse.of(line);
    }

    public List<LineResponse> findAll() {
        return lineRepository.findAll()
                .stream()
                .map(LineResponse::of)
                .collect(Collectors.toList());
    }

    public LineResponse findById(Long id) {
        return LineResponse.of(findEntityById(id));
    }

    private Line findEntityById(Long id) {
        return lineRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Long id) {
        lineRepository.deleteById(id);
    }
}
