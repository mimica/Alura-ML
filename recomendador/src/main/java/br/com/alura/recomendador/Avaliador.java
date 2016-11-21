package br.com.alura.recomendador;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {

	public static void main(String[] args) throws TasteException, IOException {
		
		RandomUtils.useTestSeed();
		
		File file = new File("dados.csv");
		DataModel model = new FileDataModel(file);
		
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadorDeProdutosBuilder();
		double erro = evaluator.evaluate(builder, null, model, 0.9, 1.0);
		System.out.println("erro médio = "+erro);
	}
}
