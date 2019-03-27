//package com.wyd.elk_solr.lesson4;
//import java.util.Iterator;
//import java.util.Map;
// 
//import org.elasticsearch.action.search.SearchRequestBuilder;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.search.aggregations.Aggregation;
//import org.elasticsearch.search.aggregations.AggregationBuilders;
//import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
//import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
//import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
//import org.junit.Test;
// 
//import utils.NesUtils;
// 
//public class TestAggregation
//{
//    @Test
//    public void testAggregation()
//    {
//        SearchRequestBuilder srb = NesUtils.getSearcher("school");
//        srb.setTypes("student");
//        srb.setSearchType(SearchType.COUNT);
// 
//        TermsBuilder gradeTermsBuilder = AggregationBuilders.terms("gradeAgg").field("grade");
//        TermsBuilder classTermsBuilder = AggregationBuilders.terms("classAgg").field("class");
// 
//        gradeTermsBuilder.subAggregation(classTermsBuilder);
// 
//        srb.addAggregation(gradeTermsBuilder);
// 
//        SearchResponse sr = srb.execute().actionGet();
// 
//        Map<String, Aggregation> aggMap = sr.getAggregations().asMap();
// 
//        StringTerms gradeTerms = (StringTerms) aggMap.get("gradeAgg");
// 
//        Iterator<Bucket> gradeBucketIt = gradeTerms.getBuckets().iterator();
// 
//        while(gradeBucketIt.hasNext())
//        {
//            Bucket gradeBucket = gradeBucketIt.next();
//            System.out.println(gradeBucket.getKey() + "年级有" + gradeBucket.getDocCount() +"个学生。");
// 
//            StringTerms classTerms = (StringTerms) gradeBucket.getAggregations().asMap().get("classAgg");
//            Iterator<Bucket> classBucketIt = classTerms.getBuckets().iterator();
// 
//            while(classBucketIt.hasNext())
//            {
//                Bucket classBucket = classBucketIt.next();
//                System.out.println(gradeBucket.getKey() + "年级" +classBucket.getKey() + "班有" + classBucket.getDocCount() +"个学生。");
//            }
//            System.out.println();
//        }
// 
//    }
//}