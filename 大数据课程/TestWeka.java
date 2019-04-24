

//Ҫ����weka.jar��



import weka.core.Instances;

import weka.core.converters.ConverterUtils.DataSource;




public class TestWeka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��һ��arrf�ļ����������м�¼�������һ�����Ե�ֵ
		String DataPath="F:\\eclipse-workspaces\\BigData\\BigData\\Data\\iris.arff";
		DataSource source = null;   

		Instances instances = null;

		try {
			source = new DataSource(DataPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			instances = source.getDataSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		instances.setClassIndex(instances.numAttributes()-1);   //�������ǩ��Ӧ������
		
		double []SepallengthValue = new double[instances.numInstances()];
		
		for(int i=0; i<instances.numInstances(); i++){
		      //System.out.println(instances.instance(i).value(0));
		      SepallengthValue[i]= (float) instances.instance(i).value(0);
		}
		System.out.println("��ƽ����"+getAverage(SepallengthValue));
		System.out.println("���"+getVariance(SepallengthValue));
        //System.out.println("��׼�"+getStandardDiviation(SepallengthValue));
        
	}
	/**
     * �����˫����������ֵ�����ֵ
     * 
     * @param inputData ������������
     * @return ������,�������ֵ���Ϸ�������Ϊ-1
     */
    public static double getMax(double[] inputData) {
        if (inputData == null || inputData.length == 0) {
            return -1;
        }

        int len = inputData.length;
        double max = inputData[0];

        for (int i = 0; i < len; i++) {
            if (max < inputData[i]) {
                max = inputData[i];
            }
        }
        return max;
    }

    /**
     * �������˫����������ֵ����Сֵ
     * 
     * @param inputData ������������
     * @return ������,�������ֵ���Ϸ�������Ϊ-1
     */
    public static double getMin(double[] inputData) {
        if (inputData == null || inputData.length == 0) {
            return -1;
        }
        int len = inputData.length;
        double min = inputData[0];
        for (int i = 0; i < len; i++) {
            if (min > inputData[i]) {
                min = inputData[i];
            }
        }
        return min;
    }

    /**
     * �����˫����������ֵ�ĺ�
     * 
     * @param inputData ������������
     * @return ������
     */
    public static double getSum(double[] inputData) {
        if (inputData == null || inputData.length == 0) {
            return -1;
        }
        int len = inputData.length;
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + inputData[i];
        }

        return sum;
    }

    /**
     * �����˫����������ֵ����Ŀ
     * 
     * @param inputData ������������
     * @return ������
     */
    public static int getCount(double[] inputData) {
        if (inputData == null) {
            return -1;
        }

        return inputData.length;
    }

    /**
     * �����˫����������ֵ��ƽ��ֵ
     * 
     * @param inputData ������������
     * @return ������
     */
    public static double getAverage(double[] inputData) {
        if (inputData == null || inputData.length == 0) {
            return -1;
        }
        int len = inputData.length;
        double result;
        result = getSum(inputData) / len;

        return result;
    }

    /**
     * �����˫����������ֵ��ƽ����
     * 
     * @param inputData ������������
     * @return ������
     */
    public static double getSquareSum(double[] inputData) {
        if(inputData == null || inputData.length == 0) {
            return -1;
        }
        int len = inputData.length;
        double sqrsum = 0.0;
        for (int i = 0; i < len; i++) {
            sqrsum = sqrsum + inputData[i] * inputData[i];
        }


        return sqrsum;
    }

	 /**
     * �����˫����������ֵ�ķ���
     * 
     * @param inputData ������������
     * @return ������
     */
    public static double getVariance(double[] inputData) {
        int count = getCount(inputData);
        double sqrsum = getSquareSum(inputData);
        double average = getAverage(inputData);
        double result;
        result = (sqrsum - count * average * average) / count;

        return result; 
    }

    /**
     * �����˫����������ֵ�ı�׼��
     * 
     * @param inputData ������������
     * @return ������
     */
    public static double getStandardDiviation(double[] inputData) {
        double result;
        //����ֵ������Ҫ
        result = Math.sqrt(Math.abs(getVariance(inputData)));

        return result;

    }


}
