
# Goals #
 
* All our RDF transformations should be performed with Metafacture / Metamorph 
* Ideas behind this approach for transformations: 
1. Metadata specialists should be able to define the concepts in an abstract way without the need to think about implementation in any programing language
similar as described in http://www.dlib.org/dlib/may15/boehme/05boehme.html Introduction:Transparency 
2. Additional goals are described in: General requirements for future tools and the infrastructure to be created by linked.swissbib.ch (and swissbib classic)
 (http://swissbib.blogspot.ch/search/label/semantic%20web)
 
 
 
# done so far #

* we created transformations for
    * bibliographic resources 
        * https://github.com/linked-swissbib/mfWorkflows/tree/master/src/main/resources/transformation/resource
    * person entities 
        * https://github.com/linked-swissbib/mfWorkflows/tree/master/src/main/resources/transformation/person
        * https://github.com/linked-swissbib/mfWorkflows/blob/master/src/main/resources/transformation/person/personMorph.xml
        * outputexample: 
    * organizations
        * https://github.com/linked-swissbib/mfWorkflows/blob/master/src/main/resources/transformation/organisation/organisationMorph.xml
        
    * work entities
        * https://github.com/linked-swissbib/mfWorkflows/tree/master/src/main/resources/transformation/work
        * these entities are based on so called FRBR clusters created by our CBS data hub
        * outputexample: https://github.com/linked-swissbib/mfWorkflows/blob/master/src/main/resources/transformation/work/workOutput.rdf
    * item data (work in progress)
        * https://github.com/linked-swissbib/mfWorkflows/tree/master/src/main/resources/transformation/item

### lessons learned
#### Metamorph transformations with a focus on RDF/XML or JSON-LD
* in a first step all our Metamorph transformations were serialized in RDF/XML.     
Because we use Elasticsearch as data store an additional transformation to JSON-LD had to be done in a subsequent Metafacture module. 
This is resource intensive and unnecessary. Therefor we changed the transformations in a way which makes it easier for the next module to create JSON (ES Bulk structures)
* https://github.com/linked-swissbib/mfWorkflows/tree/master/src/main/resources/transformation/jsonld 
* todo: give more information
        

## Problem
* for some cases we are using the sort-triples and collect-triples commands to process large amounts of data. E.g. to analyze bibliographic data or for transformations of work entities
* https://github.com/linked-swissbib/mfWorkflows/blob/master/src/main/resources/transformation/work/work.flux#L16
* https://github.com/linked-swissbib/mfWorkflows/blob/master/src/main/resources/statistics/item.flux#L11
* https://github.com/linked-swissbib/mfWorkflows/blob/master/src/main/resources/transformation/jsonld/transformation.flux#L48

We get in trouble because of insufficient memory and had to split the data in smaller sets for processing.

### Question
I have seen there is a mechanism triggered by a flag called 'memorylow' 
https://github.com/culturegraph/metafacture-core/blob/master/src/main/java/org/culturegraph/mf/stream/pipe/sort/AbstractTripleSort.java#L99
which makes it possible to swap triples to the file system as temporary store
* is this mechanism used by any other? Are there any experiences with it?
* As far as I have seen is the memorylow flag only accessible via Java (not Flux) because there is no setter-method. Did I miss something


Thanks for any hints    
        
