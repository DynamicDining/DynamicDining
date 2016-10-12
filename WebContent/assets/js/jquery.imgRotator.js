;(function($, window, undefined) {
    
    'use strict';
    
    var Modernizr = window.Modernizr;
    
    // Constructor function for our new ImgRotator object
    $.ImgRotator = function(options, element) {
      
        this.$element = $(element);
        this._init(options);
        
    };
    
    // Set up our default options
    $.ImgRotator.defaults = {
        
        speed: 700,
        easing: 'ease',
        interval: 8000

    };
    
    // Create methods for our new object
    $.ImgRotator.prototype = {
        
        _init: function(options) {
            
            this.options = $.extend(true, $.ImgRotator.defaults, options);
            
            this._config();
            
            // Show current quote item
            this.$items.eq(this.current).addClass('imageCurrent');
            
            if (this.support) {
                
                this._setTransition();
                
            }
            
            // Start rotating the quotes
            this._startRotator();
            
        },
        
        _config: function() {
            
            this.$items = $('div.imageContent');
            
            this.itemsCount = this.$items.length;
            
            this.current = 0;
            
            this.support = Modernizr.csstransitions;
            
            if (this.support) {
                
                this.$progress = $('<span class="imageProgress"></span>').appendTo(this.$element);
                
            }
            
        },
        
        _setTransition: function() {
        
            setTimeout($.proxy(function() {
                
                this.$items.css('transition', 'opacity ' + this.options.speed + 'ms ' + this.options.easing);
                
            }, this), 25);
            
        },
        
        
        _startRotator: function() {
            
            // animate progress bar from 0 to 100% width over a duration
            if (this.support) {
                this._startProgress();
            }
            
            setTimeout($.proxy(function() {
                
                if(this.support) {
                    this._resetProgress();
                }
                
                // quote animation
                this._nextImage();
                
                // Begin next rotation using a recursive function call
                this._startRotator();
                
            }, this), this.options.interval)
            
        }, 
        
        _startProgress: function() {
            
            setTimeout($.proxy(function() {
                
                this.$progress.css( { 
                    transition: 'width ' + this.options.interval + 'ms linear',
                    width: '100%'
                });
                
            }, this), 25);
            
        },
        
        _resetProgress: function () {
            
            this.$progress.css({               
                transition: 'none',
                width: '0%'                
            });
            
        },
        
        _nextImage: function() {
        
            // hide current quote
            this.$items.eq(this.current).removeClass('imageCurrent');
        
            // get index of next quote
            this.current = this.current < this.itemsCount - 1 ? this.current + 1 : this.current = 0;
            
            // show next quote
            this.$items.eq(this.current).addClass('imageCurrent');
        }
        
        
    };
    
    
    
    
    
    $.fn.qtRotator = function(options) {
       
        if (typeof options === 'string') {
            
            // not as common, leave off code for now...
            
        }
        else {  // options !== 'string', usually meaning it is an object
            
            // here, this refers the jQuery object that was used
            // to call this plugin method ($('#quoteRotator'))
            this.each(function() {
                
                var instance = $.data(this, 'imgRotator');
                
                if (instance) {
                    instance._init();
                }
                else {
                    
                    instance = $.data(this, 'imgRotator', new $.ImgRotator(options, this));
                    
                }
                
            });
            
        } // end outer else
		
        return this; // make our pluggin method chainable....
        
    };
        
})(jQuery, window);