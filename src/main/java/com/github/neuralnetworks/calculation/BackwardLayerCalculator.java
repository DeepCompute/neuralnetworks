package com.github.neuralnetworks.calculation;

import java.util.Map;

import com.github.neuralnetworks.architecture.Connections;
import com.github.neuralnetworks.architecture.Layer;

public class BackwardLayerCalculator implements LayerCalculator {

	@Override
	public float[] calculate(Map<Layer, float[]> calculatedLayers, Layer layer) {
		float[] result = new float[layer.getNeuronCount()];
		for (Connections c : layer.getOutboundConnectionGraphs()) {
			layer.getInputFunction().calculateBackward(c, calculatedLayers.get(c.getOutputLayer()), result);
		}

		layer.getActivationFunction().value(result);

		return result;
	}
}
