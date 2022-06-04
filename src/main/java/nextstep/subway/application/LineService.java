package nextstep.subway.application;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.subway.domain.Line;
import nextstep.subway.domain.LineRepository;
import nextstep.subway.domain.Station;
import nextstep.subway.domain.StationRepository;
import nextstep.subway.dto.LineRequest;
import nextstep.subway.dto.LineResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LineService {

    private LineRepository lineRepository;
    private StationRepository stationRepository;

    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    @Transactional
    public LineResponse saveLine(LineRequest lineRequest) {
        Station upStation = stationRepository.findById(lineRequest.getUpStationId())
            .orElseThrow(() -> new IllegalArgumentException("상행 역이 존재하지 않습니다."));
        Station downStation = stationRepository.findById(lineRequest.getDownStationId())
            .orElseThrow(() -> new IllegalArgumentException("하행 역이 존재하지 않습니다."));

        Line line = new Line(lineRequest.getName(), lineRequest.getColor(), upStation, downStation,
            lineRequest.getDistance());
        lineRepository.save(line);
        return LineResponse.of(line);
    }

    public List<LineResponse> findAllLine() {
        List<Line> lines = lineRepository.findAll();
        return lines.stream().map(line -> LineResponse.of(line)).collect(Collectors.toList());
    }

    public LineResponse findLine(Long id) {
        Line line = lineRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("지하철 노선이 존재하지 않습니다."));
        return LineResponse.of(line);
    }
}
