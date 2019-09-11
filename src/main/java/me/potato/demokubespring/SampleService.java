package me.potato.demokubespring;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SampleService {

    private final SampleRepository samples;

    public SampleService(SampleRepository samples) {
        this.samples = samples;
    }

    public Optional<Sample> getSample(Long id){
        return samples.findById(id);
    }

    public Collection<Sample> getAllSamples(){
        return samples.findAll();
    }

    public Optional<Sample> updateSample(Sample newSample){
        Sample save = samples.save(newSample);

        if(save != null)
            return Optional.of(save);

        return Optional.empty();
    }
}
