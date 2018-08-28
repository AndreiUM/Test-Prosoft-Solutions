<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:output indent="yes"/>

   <xsl:template match="orders">
      <xsl:result-document href="Apple.xml">
         <xsl:copy>
            <xsl:apply-templates select="order/product[contains(supplier, 'Apple')]"/>
         </xsl:copy>
      </xsl:result-document>
      <xsl:result-document href="Sony.xml">
         <xsl:copy>
         	<xsl:apply-templates select="order/product[contains(supplier, 'Sony')]"/>
            <!-- <xsl:apply-templates select="order[product[contains(supplier, 'Sony')]]"/> -->
         </xsl:copy>
      </xsl:result-document>
      <xsl:result-document href="Panasonic.xml">
         <xsl:copy>
         	<xsl:apply-templates select="order/product[contains(supplier, 'Panasonic')]"/>
            <!-- <xsl:apply-templates select="order[product[contains(supplier, 'Panasonic')]]"/> -->
         </xsl:copy>
      </xsl:result-document>
   </xsl:template>

   <xsl:template match="@* | node()">
      <xsl:copy>
         <xsl:apply-templates select="@* | node()"/>
      </xsl:copy>
   </xsl:template>
</xsl:stylesheet>